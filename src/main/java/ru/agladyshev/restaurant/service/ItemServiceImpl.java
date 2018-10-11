package ru.agladyshev.restaurant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.agladyshev.restaurant.entity.Item;
import ru.agladyshev.restaurant.repository.ItemRepositoryImpl;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {


    private ItemRepositoryImpl itemRepository;

    @Autowired
    public ItemServiceImpl(ItemRepositoryImpl itemRepository) {
        this.itemRepository = itemRepository;
    }

    public void save(Item item) {
        itemRepository.save(item);
    }
}
