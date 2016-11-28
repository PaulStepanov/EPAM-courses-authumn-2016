package domain;

/**
 * Created by Павел on 28-Nov-16.
 */
public abstract class Entity<IdType extends Object> {
    private IdType id;

    public IdType getId() {
        return id;
    }

    public void setId(IdType id) {
        this.id = id;
    }
}
