package project.tour.management_DTO;

public class TourStatusEnum {
    public enum StatusTour {
        Opening(1),
        Closed(2),
        Postpone(3)
        ;

        private int value;

        StatusTour(int value) {
            this.value = value;
        }

        public static StatusTour getStatusTourByValue(int value){
            for(StatusTour statusTour : StatusTour.values()){
                if(statusTour.value == value){
                    return statusTour;
                }
            }
            return null;
        }
    }
}
