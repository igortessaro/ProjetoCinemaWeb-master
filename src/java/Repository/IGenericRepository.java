package Repository;

public interface IGenericRepository<T> {

    void Insert(T entity);

    void Update(T entity);

    void Delete(T entity);
}
