public class time implements calculable_time{

    private int hours,
            minutes;

    public time(final int HOURS, final int MINUTES){
        this.hours = HOURS;
        this.minutes = MINUTES;
    }

    public String toString() {
        return this.hours + " : " + this.minutes;
    }


    public time calculate_time(final time TIME, final String OPERATOR) throws Exception{
        if (!(OPERATOR.equals("+")) || !(OPERATOR.equals("-"))){
            throw new Exception("illegal operation. only '+' and '-' permitted");
        } else {
            return OPERATOR.equals("-") ? new time(this.hours - TIME.hours, this.minutes - TIME.minutes) : new time(this.hours + TIME.hours, this.minutes + TIME.minutes);
        }
    }
}