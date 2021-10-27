package miniTest.managerService;

public interface ManagerService<T> {
    void add (T t);
    void updateById (T t,int id);
    void deleteById (int id);
    int findById(int id);
    void print();
}
