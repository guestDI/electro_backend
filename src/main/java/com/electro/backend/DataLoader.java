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

        Manufacturer fiolent_manufacturer = new Manufacturer("Фиолент", "Россия",
                "АО «ЗАВОД «ФИОЛЕНТ» — машиностроительное предприятие, расположенное в городе Симферополь (Крым), " +
                        "крупнейший[источник не указан 1879 дней] производитель электроинструмента в Восточной Европе.");

        Manufacturer skil_manufacturer = new Manufacturer("Skil", "Китай");

        Manufacturer solaris_manufacturer = new Manufacturer("Solaris", "Италия");

        Manufacturer yato_manufacturer = new Manufacturer("Yato", "Польша",
                "Yato - торговая марка группы компаний Toya, основанной в 1990 году в г. Вроцлав, Польша. ");

        Manufacturer vibromash_manufacturer = new Manufacturer("Вибромаш", "Россия");

        Manufacturer skiper_manufacturer = new Manufacturer("Skiper", "Китай");

        Manufacturer makita_manufacturer = new Manufacturer("Makita", "Япония",
                "В настоящее время Makita выпускает свыше 350 типов инструмента и свыше 4500 аксессуаров к ним. " +
                        "На сегодняшний день ассортимент Makita насчитывает свыше 1000 наименований.");

        Manufacturer eco_manufacturer = new Manufacturer("Eco", "Италия");

        manufacturerRepository.save(bosch_manufacturer);
        manufacturerRepository.save(fiolent_manufacturer);
        manufacturerRepository.save(skil_manufacturer);
        manufacturerRepository.save(solaris_manufacturer);
        manufacturerRepository.save(yato_manufacturer);
        manufacturerRepository.save(vibromash_manufacturer);
        manufacturerRepository.save(skiper_manufacturer);
        manufacturerRepository.save(makita_manufacturer);
        manufacturerRepository.save(eco_manufacturer);

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
        Category other = new Category("Другое");

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
        categoryRepository.save(other);

        Item bosch_gws_670 = Item.builder()
                .category(bolgarka)
                .manufacturer(bosch_manufacturer)
                .name("Bosch GWS 670 Professional")
                .description("Угловая шлифмашина. Питание: сеть, Потребляемая мощность: 670 Вт, " +
                        "Частота вращения (холостой ход): 12 000 об/мин, Резьба шпинделя: M14, Диаметр диска: 125 мм, Вес 1.5 кг")
                .quantity(1)
                .itemPhoto("https://res.cloudinary.com/dxp2voatn/image/upload/v1559564200/site/instruments/bosch_gws_670.jpg")
                .price(new BigDecimal("7"))
                .build();

        Item bosch_gws_22_230 = Item.builder()
                .category(bolgarka)
                .manufacturer(bosch_manufacturer)
                .name("Bosch GWS 22-230 H Professional")
                .description("Угловая шлифмашина. Потребляемая мощность: 2 200 Вт, " +
                        "частота вращения (холостой ход): 0 — 6 500 об/мин, резьба шпинделя: M14, диаметр диска: 230 мм, вес: 5.2 кг")
                .quantity(1)
                .itemPhoto("https://res.cloudinary.com/dxp2voatn/image/upload/v1559564200/site/instruments/bosch_gws_22_230.jpg")
                .price(new BigDecimal("9"))
                .build();

        Item bosch_gst_65 = Item.builder()
                .category(jigsaw)
                .manufacturer(bosch_manufacturer)
                .name("Bosch GST 65 B Professional")
                .description("Электролобзик. Питание: сеть, тип корпуса: рукоятка-скоба, мощность: 400 Вт, " +
                        "максимальная глубина пропила (дерево): 65 мм, максимальная глубина пропила (сталь): 8 мм, вес 2.3 кг")
                .quantity(1)
                .itemPhoto("https://res.cloudinary.com/dxp2voatn/image/upload/v1559570504/site/instruments/bosch_gst_65.jpg")
                .price(new BigDecimal(9))
                .build();

        Item bosch_gfz_16_35 = Item.builder()
                .category(saw)
                .manufacturer(bosch_manufacturer)
                .name("Bosch GFZ 16-35 AC Professional")
                .description("Пила-аллигатор. Тип питания: сеть, потребляемая мощность: 1 600 Вт, длина полотна: 35 см, " +
                        "ход полотна: 50 мм, число ходов полотна в минуту: 2 500  (850 – 2500), длина: 800 мм, " +
                        "высота: 235 мм, вес: 5.2 кг")
                .quantity(1)
                .itemPhoto("https://res.cloudinary.com/dxp2voatn/image/upload/v1559570612/site/instruments/bosch_gfz_16_35.jpg")
                .price(new BigDecimal(15))
                .build();

        Item bosch_gks_190 = Item.builder()
                .category(saw)
                .manufacturer(bosch_manufacturer)
                .name("Bosch GKS 190 Professional")
                .description("Дисковая пила. Тип питания: сеть, потребляемая мощность: 1 400 Вт, диаметр режущего диска: 190 мм, " +
                        "диаметр посадочного гнезда диска: 30 мм, глубина реза 90°: 70 мм, глубина реза 45°: 50 мм, " +
                        "скорость вращения шпинделя: 5 500 об/мин, вес: 4.2 кг")
                .quantity(1)
                .itemPhoto("https://res.cloudinary.com/dxp2voatn/image/upload/v1559571008/site/instruments/bosch_gks_190.jpg")
                .price(new BigDecimal(11))
                .build();

        Item bosch_psr_10_8 = Item.builder()
                .category(drel)
                .manufacturer(bosch_manufacturer)
                .name("Bosch PSR 10.8 LI-2")
                .description("Дрель-шуруповерт. Тип питания: аккумулятор, режимы работы: сверление, патрон: быстрозажимной, " +
                        "скорость вращения: 1 100 об/мин  (0-300/0-1100 об/мин), крутящий момент: 22 Н·м, режимы скорости вращения: 2, " +
                        "регулировка крутящего момента: 20 ступ., диаметр шурупов: 0 — 6 мм максимальный диаметр сверления, " +
                        "металл: 8 мм, максимальный диаметр сверления, дерево: 20 мм")
                .quantity(1)
                .itemPhoto("https://res.cloudinary.com/dxp2voatn/image/upload/v1559571365/site/instruments/bosch_psr_10_8.jpg")
                .price(new BigDecimal(6))
                .build();

        Item bosch_gbh_2_26_dre = Item.builder()
                .category(perforators)
                .manufacturer(bosch_manufacturer)
                .name("Bosch GBH 2-26 DRE Professional")
                .description("Перфоратор. Тип питания: сеть, режимы работы: сверление, сверление с ударом, долбление; " +
                        "мощность: 800 Вт, патрон: SDS-plus, скорость вращения: 900 об/мин, частота ударов: 4 000 ударов/мин, " +
                        "энергия удара: 2.7 Дж, максимальный диаметр сверления, бетон: 26 мм  (ударными сверлами), " +
                        "максимальный диаметр сверления, металл: 13 мм, максимальный диаметр сверления, дерево: 30 мм")
                .quantity(1)
                .itemPhoto("https://res.cloudinary.com/dxp2voatn/image/upload/v1559571837/site/instruments/bosch_gbh_2_26_dre.jpg")
                .price(new BigDecimal(7))
                .build();

        Item md1_11e = Item.builder()
                .category(mixer)
                .manufacturer(fiolent_manufacturer)
                .name("Фиолент МД1-11Э")
                .description("Дрель-миксер. Мощность: 1100 Вт, 1 скорость")
                .quantity(1)
                .itemPhoto("https://res.cloudinary.com/dxp2voatn/image/upload/v1559594873/site/instruments/md1_11e.jpg")
                .price(new BigDecimal(6))
                .build();

        Item skil_1608_la = Item.builder()
                .category(mixer)
                .manufacturer(skil_manufacturer)
                .name("Skil 1608 LA")
                .description("Дрель-миксер. Мощность: 850 Вт, 1 скорость")
                .quantity(1)
                .itemPhoto("https://res.cloudinary.com/dxp2voatn/image/upload/v1559595046/site/instruments/skil_1608_la.jpg")
                .price(new BigDecimal(6))
                .build();

        Item bosch_gnf_35 = Item.builder()
                .category(shtoborez)
                .manufacturer(bosch_manufacturer)
                .name("Bosch GNF 35 CA Professional")
                .description("Бороздодел. Потребляемая мощность: 1 400 Вт, выходная мощность: 820 Вт, " +
                        "частота вращения (холостой ход): 9 300 об/мин, глубина паза: 0 — 35 мм, ширина паза: 3 — 39 мм, " +
                        "диаметр диска: 150 мм, вес: 4.7 кг")
                .quantity(1)
                .itemPhoto("https://res.cloudinary.com/dxp2voatn/image/upload/v1559595265/site/instruments/bosch_gnf_35.jpg")
                .price(new BigDecimal(15))
                .build();

        Item bosch_gsh_16_30 = Item.builder()
                .category(betonlom)
                .manufacturer(bosch_manufacturer)
                .name("Bosch GSH 16-30 Professional")
                .description("Отбойный молоток. Электрический, мощность: 1750 Вт, удар 41 Дж, частота 1300 об/мин, вес: 16.5 кг")
                .quantity(1)
                .itemPhoto("https://res.cloudinary.com/dxp2voatn/image/upload/v1559595733/site/instruments/bosch_gsh_16_30.jpg")
                .price(new BigDecimal(25))
                .build();

        Item bosch_gsh_5_ce = Item.builder()
                .category(betonlom)
                .manufacturer(bosch_manufacturer)
                .name("Bosch GSH 5 CE Professional")
                .description("Отбойный молоток. Электрический, электрический, мощность 1150 Вт, удар 8.3 Дж, " +
                        "частота 2900 об/мин, вес: 6.2 кг")
                .quantity(1)
                .itemPhoto("https://res.cloudinary.com/dxp2voatn/image/upload/v1559595921/site/instruments/bosch_gsh_5_ce.jpg")
                .price(new BigDecimal(10))
                .build();

        Item bosch_gas_55_m_afc = Item.builder()
                .category(vacuum)
                .manufacturer(bosch_manufacturer)
                .name("Bosch GAS 55 M AFC")
                .description("Пылесос. Тип: хозяйственный, пылесборник: контейнер, мощность: 1 380 Вт, " +
                        "труба: составная, материал трубы: сталь, автоматическое сматывание шнура, регулировка мощности: на корпусе," +
                        " объём пылесборника: 43 л (контейнер для сбора воды - 40 л)")
                .quantity(1)
                .itemPhoto("https://res.cloudinary.com/dxp2voatn/image/upload/v1559596198/site/instruments/bosch_gas_55_m_afc.jpg")
                .price(new BigDecimal(13))
                .build();

        Item bosch_gll_2_10 = Item.builder()
                .category(measure)
                .manufacturer(bosch_manufacturer)
                .name("Bosch GLL 2-10 Professional")
                .description("Лазерный нивелир. Призменный, дальность: 10 м, точность: 3 мм, компенсатор: ±4°, корпус IP54")
                .quantity(1)
                .itemPhoto("https://res.cloudinary.com/dxp2voatn/image/upload/v1559596740/site/instruments/bosch_gll_2_10.jpg")
                .price(new BigDecimal(8))
                .build();

        Item solaris_pw_1501 = Item.builder()
                .category(welding)
                .manufacturer(solaris_manufacturer)
                .name("Solaris PW-1501")
                .description("Аппарат для сварки труб. Мощность: 1500 Вт, мечевидный, 300 °C, термостат, нагрев 3 минуты, " +
                        "с тефлоновым покрытием, насадки 20 мм/25 мм/32 мм/40 мм/50 мм/63 мм, труборез, кейс")
                .quantity(1)
                .itemPhoto("https://res.cloudinary.com/dxp2voatn/image/upload/v1559597091/site/instruments/solaris_pw_1501.jpg")
                .price(new BigDecimal(5))
                .build();

        Item yato_yt_3708 = Item.builder()
                .category(tileCutter)
                .manufacturer(yato_manufacturer)
                .name("Yato YT-3708")
                .description("Ручной плиткорез. Ручной, глубина реза: 16 мм")
                .quantity(1)
                .itemPhoto("https://res.cloudinary.com/dxp2voatn/image/upload/v1559597409/site/instruments/yato_yt_3708.jpg")
                .price(new BigDecimal(10))
                .build();

        Item vi_1_17_3 = Item.builder()
                .category(immersionVibrator)
                .manufacturer(vibromash_manufacturer)
                .name("Вибромаш ВИ 1-17-3")
                .description("Вибратор глубинный. Мощность (Вт): 1400, напряжение: 220В (1ф), длина вала (м): 3, " +
                        "диаметр вибронаконечника (мм): 51, длина вибронаконечника (мм): 420, частота вибрации: 285, " +
                        "длина (мм): 350, ширина (мм): 180, высота (мм): 270, вес (кг): 25")
                .quantity(1)
                .itemPhoto("https://res.cloudinary.com/dxp2voatn/image/upload/v1559597601/site/instruments/vi_1_17_3.jpg")
                .price(new BigDecimal(12))
                .build();

        Item skiper_c_60_honda = Item.builder()
                .category(other)
                .manufacturer(skiper_manufacturer)
                .name("Skiper С-60 Honda GX160")
                .description("Виброплита. Двигатель: бензиновый, модель двигателя: Honda GX160, мощность двигателя в л.с.: 4.8 л.с., " +
                        "масса: 60 кг, центробежная сила: 9 кН, глубина уплотнения: 20 см, частота вибрации: 72 Гц, " +
                        "скорость движения: 25 м/мин, рабочий объём двигателя: 163 см3, емкость топливного бака: 3.1 л, расход топлива: 1.4 л/ч")
                .quantity(1)
                .itemPhoto("https://res.cloudinary.com/dxp2voatn/image/upload/v1559631838/site/instruments/skiper_c_60_honda.jpg")
                .price(new BigDecimal(23))
                .build();

        Item makita_DPC7331 = Item.builder()
                .category(other)
                .manufacturer(makita_manufacturer)
                .name("Makita DPC7331")
                .description("Бензорез. 4.2 кВт, диск: 350 мм, глубина реза: 122 мм, 9.7 ")
                .quantity(1)
                .itemPhoto("https://res.cloudinary.com/dxp2voatn/image/upload/v1559632446/site/instruments/makita_DPC7331.jpg")
                .price(new BigDecimal(22))
                .build();

        Item eco_cma_200 = Item.builder()
                .category(concreteMixer)
                .manufacturer(eco_manufacturer)
                .name("Eco CMA-200")
                .description("Бетоносмеситель. Мощность (Вт): 1100, объем готовой смеси (л): 140, напряжение: 220В (1ф), " +
                        "число оборотов (об/мин): 26, объем (л): 200, длина (мм): 870, ширина (мм): 710, высота (мм): 510, вес (кг): 52")
                .quantity(1)
                .itemPhoto("https://res.cloudinary.com/dxp2voatn/image/upload/v1559632741/site/instruments/eco_cma_200.jpg")
                .price(new BigDecimal(13))
                .build();

        itemRepository.save(bosch_gws_670);
        itemRepository.save(bosch_gws_22_230);
        itemRepository.save(bosch_gst_65);
        itemRepository.save(bosch_gfz_16_35);
        itemRepository.save(bosch_gks_190);
        itemRepository.save(bosch_psr_10_8);
        itemRepository.save(bosch_gbh_2_26_dre);
        itemRepository.save(md1_11e);
        itemRepository.save(skil_1608_la);
        itemRepository.save(bosch_gnf_35);
        itemRepository.save(bosch_gsh_16_30);
        itemRepository.save(bosch_gsh_5_ce);
        itemRepository.save(bosch_gas_55_m_afc);
        itemRepository.save(bosch_gll_2_10);
        itemRepository.save(solaris_pw_1501);
        itemRepository.save(yato_yt_3708);
        itemRepository.save(vi_1_17_3);
        itemRepository.save(skiper_c_60_honda);
        itemRepository.save(makita_DPC7331);
        itemRepository.save(eco_cma_200);
    }
}
