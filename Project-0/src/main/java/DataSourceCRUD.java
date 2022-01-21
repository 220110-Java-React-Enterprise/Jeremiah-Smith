// interface for Repo classes, ensures proper jdbc functionality
public interface DataSourceCRUD<T> {
    public T create(T t);
    public T read(Integer id);
    public T update(T t);
    public void delete(Integer id);
}