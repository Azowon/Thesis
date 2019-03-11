package david.microservices.sport;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;


import java.util.List;

@Component
public class Logic {

    @Autowired
    private SportDataJpaRespository sportDataJpaRespository;

    public void deleteSportsData(long id) { sportDataJpaRespository.deleteById(id); }

    public void insert(SportData sportData) {
        sportDataJpaRespository.save(sportData);
    }

    public List<SportData> getAll() {
        return sportDataJpaRespository.findAll();
    }

    public List<SportData> getUserSportsById(int id) {
        return sportDataJpaRespository.findByUserID(id);
    }

    public List<SportData> getSportsType(int id, String type) {
        return sportDataJpaRespository.findByUserIDAndType(id, type);
    }
}
