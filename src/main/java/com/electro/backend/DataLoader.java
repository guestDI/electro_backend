package com.electro.backend;

import com.electro.backend.model.Category;
import com.electro.backend.model.Manufacturer;
import com.electro.backend.repository.CategoryRepository;
import com.electro.backend.repository.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional(propagation = Propagation.REQUIRED)
public class DataLoader implements ApplicationRunner {

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        Manufacturer bosch_manufacturer = new Manufacturer("Bosch", "Германия",
                "Роберт Бош ГМБХ. Германия, 70839 Герлинген-Счиллерхохе, Роберт-Бош-Платц, 1");
        manufacturerRepository.save(bosch_manufacturer);


        Category drel = new Category("Дрели и шуроповерты");
        Category vacuum = new Category("Пылесосы");
        Category jointer = new Category("Рубанки");
        Category saw = new Category("Пилы и лобзики");
        Category bolgarka = new Category("Болгарки");

        categoryRepository.save(drel);
        categoryRepository.save(vacuum);
        categoryRepository.save(jointer);
        categoryRepository.save(saw);
        categoryRepository.save(bolgarka);

    }
}
