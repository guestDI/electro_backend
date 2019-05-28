package com.electro.backend;

import com.electro.backend.model.Category;
import com.electro.backend.model.Item;
import com.electro.backend.model.Manufacturer;
import com.electro.backend.repository.CategoryRepository;
import com.electro.backend.repository.ItemRepository;
import com.electro.backend.repository.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Component
@Transactional(propagation = Propagation.REQUIRED)
public class DataLoader implements ApplicationRunner {

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        Manufacturer bosch_manufacturer = new Manufacturer("Bosch", "Германия",
                "Роберт Бош ГМБХ. Германия, 70839 Герлинген-Счиллерхохе, Роберт-Бош-Платц, 1");
        manufacturerRepository.save(bosch_manufacturer);


        Category perforators = new Category("Перфораторы",
                "https://res.cloudinary.com/dxp2voatn/image/upload/v1559030651/site/categories/perforators.jpg");
        Category drel = new Category("Шуроповерты",
                "https://res.cloudinary.com/dxp2voatn/image/upload/v1559030651/site/categories/shur.jpg");
        Category mixer = new Category("Миксеры");
        Category vacuum = new Category("Пылесосы",
                "https://res.cloudinary.com/dxp2voatn/image/upload/v1559031032/site/categories/vacuum.jpg");
        Category jigsaw = new Category("Лобзики",
                "https://res.cloudinary.com/dxp2voatn/image/upload/v1559031193/site/categories/lobzik.jpg");
        Category saw = new Category("Пилы",
                "https://res.cloudinary.com/dxp2voatn/image/upload/v1559034374/site/categories/pila.jpg");
        Category bolgarka = new Category("УШМ (Болгарки)",
                "https://res.cloudinary.com/dxp2voatn/image/upload/v1559031599/site/categories/usm.jpg");
        Category shtoborez = new Category("Штроборезы",
                "https://res.cloudinary.com/dxp2voatn/image/upload/v1559031710/site/categories/shtroborez.jpg");
        Category betonlom = new Category("Бетоноломы");
        Category measure = new Category("Измерительные приборы");
        Category tileCutter = new Category("Плиткорезы");
        Category welding = new Category("Аппарат для сварки труб");
        Category immersionVibrator = new Category("Глубинный вибратор");
        Category concreteMixer = new Category("Бетономешалки");

        categoryRepository.save(perforators);
        categoryRepository.save(drel);
        categoryRepository.save(vacuum);
        categoryRepository.save(jigsaw);
        categoryRepository.save(bolgarka);
        categoryRepository.save(shtoborez);
        categoryRepository.save(saw);
        categoryRepository.save(tileCutter);
        categoryRepository.save(measure);
        categoryRepository.save(mixer);
        categoryRepository.save(betonlom);
        categoryRepository.save(welding);
        categoryRepository.save(immersionVibrator);
        categoryRepository.save(concreteMixer);


        Item item = Item.builder()
                .category(drel)
                .manufacturer(bosch_manufacturer)
                .name("Bosch GSR 120-LI Professional 06019F7004")
                .description("дрель-шуруповерт, аккумулятор 12V, Li-ion, патрон быстрозажимной, 2 скорости, режимы: сверление/шуруповерт")
                .quantity(2)
                .price(new BigDecimal("30"))
                .build();

        Item item2 = Item.builder()
                .category(vacuum)
                .manufacturer(bosch_manufacturer)
                .name("Bosch GAS 35 L AFC ")
                .description("Сухая и влажная уборка, контейнер на 23л, мощность 1380Вт")
                .quantity(1)
                .price(new BigDecimal("40"))
                .build();

        Item item3 = Item.builder()
                .category(saw)
                .manufacturer(bosch_manufacturer)
                .name("Bosch GST 8000 E Professional")
                .description("710 Вт, рукоятка-скоба, глубина пропила: 80 мм (дерево), 10 мм (сталь), 500–3100 ходов/мин, ход пилки: 20 мм, 2.5 кг")
                .quantity(1)
                .price(new BigDecimal(20))
                .build();

        itemRepository.save(item);
        itemRepository.save(item2);
        itemRepository.save(item3);
    }
}
