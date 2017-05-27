package com.diyill.idworker;

/**
 * @author liuwei
 * @version 17/5/27 下午2:36
 * @modified TODO
 * @description 功能描述
 * @see
 * @since 1.0
 *
 * | 41 bits: Timestamp | 3 bits: 区域 | 10 bits: 机器编号 | 10 bits: 序列号 |
 */
public class SnowflakeIdWorker {

    //2017/5/27 14:38:00
    private final long twepoch = 1495867080000L;
    private final long regionIdBits = 3L;
    private final long workerIdBits = 10L;
    private final long sequenceBits = 10L;

    private final long timestampShift = sequenceBits + workerIdBits + regionIdBits;
    private final long regionIdShift = sequenceBits + workerIdBits;
    private final long workerIdShift = sequenceBits;

    private final long maxRegionId = -1L ^ -1L << regionIdBits;
    private final long maxWorkerId = -1L ^ -1L << workerIdBits;
    private final long maxSequence = -1L ^ -1L << sequenceBits;

    private long sequence = 1L;
    private long lastTimestamp = -1L;

    private long workerId;
    private long regionId;

    public SnowflakeIdWorker(long workerId) {
        this(workerId , 0L);
    }

    public SnowflakeIdWorker(long workerId, long regionId) {
        if(workerId < 0 || workerId > this.maxWorkerId){
            throw new IllegalArgumentException(String.format("worker Id can't be greater than %d or less than 0" , maxWorkerId));
        }
        if(regionId < 0 || regionId > this.maxRegionId){
            throw new IllegalArgumentException(String.format("region Id can't be greater than %d or less than 0" , maxRegionId));
        }
        this.workerId = workerId;
        this.regionId = regionId;
    }

    public long nextId(){
        long timestamp = this.timeGen();
        if (timestamp == this.lastTimestamp) {
            this.sequence = (this.sequence + 1) & this.maxSequence;
            if (this.sequence == 0) {
                timestamp = this.tilNextMillis(this.lastTimestamp);
            }
        } else {
            this.sequence = 0L;
        }
        if(timestamp < this.lastTimestamp){
            try {
                throw new Exception(String.format("Clock moved backwards. Refusing to generate id for %d milliseconds",
                        this.lastTimestamp - timestamp));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.lastTimestamp = timestamp;
        long nextId = timestamp - this.twepoch << this.timestampShift
                | this.regionId << this.regionIdShift
                | this.workerId << this.workerIdShift
                | this.sequence;
        System.out.println("timestamp:" + timestamp + ",regionId:"
                + regionId + ",nextId:" + nextId + ",workerId:"
                + workerId + ",sequence:" + sequence);
        return nextId;
    }

    public String decode(long id){
        return String.format("Timestamp=%s,regionId=%s,workerId=%s,sequence=%s" ,
                this.decodeTimestamp(id) ,
                this.decodeRegionId(id) ,
                this.decodeWorkerId(id) ,
                this.decodeSequence(id));
    }

    public long decodeTimestamp(long id){
        return (id >> this.timestampShift) + this.twepoch;
    }

    public long decodeRegionId(long id){
        return id >> this.regionIdShift & maxRegionId;
    }

    public long decodeWorkerId(long id){
        return id >> this.workerIdShift & this.maxWorkerId;
    }

    public long decodeSequence(long id){
        return id & this.maxSequence;
    }

    private long timeGen(){
        return System.currentTimeMillis();
    }

    private long tilNextMillis(long lastTimestamp){
        long timestamp = this.timeGen();
        while(timestamp <= lastTimestamp){
            timestamp = this.timeGen();
        }
        return timestamp;
    }

    public static void main(String[] args) {
        final SnowflakeIdWorker idWorker = new SnowflakeIdWorker(5,4);
        for (int i = 0; i < 1000; i++) {
            new Thread(){
                @Override
                public void run() {
                    System.out.println(idWorker.decode(idWorker.nextId()));
                }
            }.start();
        }
    }
}
