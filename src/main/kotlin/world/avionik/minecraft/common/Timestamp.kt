package world.avionik.minecraft.common

/**
 * @author Frederick Baier
 */

data class Timestamp(
    private val time: Long = System.currentTimeMillis()
) {

    fun isAfter(timestamp: Timestamp): Boolean {
        return !isBefore(timestamp)
    }

    fun isBefore(timestamp: Timestamp): Boolean {
        return this.time < timestamp.time
    }

    fun hasTimePassed(timeInMillis: Long): Boolean {
        return getTimePassed() > timeInMillis
    }

    fun getTimeLeftTo(timestamp: Timestamp): Long {
        return timestamp.time - this.time
    }

    fun getTimePassed(): Long = this.time

    companion object {
        fun createTimestampFromNow(additionalTime: Long): Timestamp {
            return Timestamp(System.currentTimeMillis() - additionalTime)
        }
    }
}