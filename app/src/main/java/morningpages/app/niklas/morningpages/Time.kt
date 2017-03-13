package morningpages.app.niklas.morningpages

/**
 * @author nwuensche
 */
class Time(val hours: Int, val minutes: Int, val seconds: Int) {

    override fun toString(): String {
        val displayHours = if (hours < 10) "0$hours" else "$hours"
        val displayMinutes = if (minutes < 10) "0$minutes" else "$minutes"
        val displaySeconds = if (seconds < 10) "0$seconds" else "$seconds"
        return "$displayHours:$displayMinutes:$displaySeconds"
    }

    fun tick(): Time {
        val subtractMinutes = seconds == 0
        val subtractHours = if (subtractMinutes && minutes == 0) 1 else 0

        val newSeconds = if (seconds == 0) 59 else seconds - 1
        val newMinutes = if (subtractMinutes && minutes == 0) 59 else if (subtractMinutes) minutes - 1 else minutes
        val newHours = hours - subtractHours

        return Time(newHours, newMinutes, newSeconds)
    }

}