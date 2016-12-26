package controller.controlers.filters;


enum Privilege {
    USER(0), MODERATOR(1), ADMIN(2);
    private Integer value;

    Privilege(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
