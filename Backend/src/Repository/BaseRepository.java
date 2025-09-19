package Repository;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public abstract class BaseRepository <T, ID> {
        Map<ID, T> map = new HashMap<ID, T>();
        protected ArrayList<T> list = new ArrayList<T>();
        public Optional<T> findById(ID id){
            return Optional.ofNullable(Map.get(id));
        }
        public List <T> findAll(){
          return list;
        }
        public abstract void save(T entity);
        public abstract void getId(T entity);
}
