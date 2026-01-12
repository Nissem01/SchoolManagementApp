public enum CourseType {

    MATTE("Matematik"),
    ENGELSKA("Engelska"),
    IDROTT("Idrott");

    private String displayName;
    CourseType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
