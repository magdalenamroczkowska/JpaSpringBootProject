package pl.kurs.javaspring_10.dao;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.lang.reflect.ParameterizedType;


@Transactional
public abstract class GenericDao<T, K> {

    @PersistenceContext
    private EntityManager entityManager;
    private Class<T> type;

    //- wyciągniecie tej klasy z nawiasów trójkątnych
    @SuppressWarnings("unchecked")
    GenericDao(){
        type = (Class<T>) ((ParameterizedType) this.getClass()
                .getGenericSuperclass())
                .getActualTypeArguments()[0];
    }
//
//    GenericDao(Class<T> type){
//        this.type = type;
//    }
    public void save(T entity){
        entityManager.persist(entity);
    }
    public T get(K key){
        T find = entityManager.find(type, key);
        return find;
    }

}
