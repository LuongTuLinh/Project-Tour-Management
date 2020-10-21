package project.tour.management_DTO;

public enum EnumStatusTour {
        ĐangMở(1),
        Đóng(2),
        TạmHoãn(3),

        ;


    private int value;

    EnumStatusTour(int value) {
        this.value = value;
    }
    public static EnumStatusTour getWeekDayByValue(int value) {
        for (EnumStatusTour status : EnumStatusTour.values()) {
            if (status.value == value) {
                return status;
            }
        }
        return null;
    }
}
