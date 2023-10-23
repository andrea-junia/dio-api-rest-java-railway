package dio.desafio.apirestjavarailway.domain.services.impl;

import dio.desafio.apirestjavarailway.domain.model.Doctor;
import dio.desafio.apirestjavarailway.domain.model.Item;
import dio.desafio.apirestjavarailway.domain.repository.ItemRepository;
import dio.desafio.apirestjavarailway.domain.services.ItemService;
import dio.desafio.apirestjavarailway.domain.services.exception.BusinessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

import static java.util.Optional.ofNullable;

@Service
public class ItemServiceImpl implements ItemService {

    private static final Long UNCHANGEABLE_USER_ID = 1L;

    private final ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public List<Item> findAll(){
        return itemRepository.findAll();
    }

    @Override
    public Item findById(Long id) {
        return itemRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Transactional
    public Item create(Item itemToCreate) {
        ofNullable(itemToCreate).orElseThrow(() -> new BusinessException("Entity Item to create must not be null."));
        this.validateChangeableId(itemToCreate.getId(), "created");
        return this.itemRepository.save(itemToCreate);
    }

    @Transactional
    public Item update(Long id, Item itemToUpdate) {
        this.validateChangeableId(id, "updated");
        Item dbItem = this.findById(id);
        if (!dbItem.getId().equals(itemToUpdate.getId())) {
            throw new BusinessException("Update IDs must be the same.");
        }

        dbItem.setDescription(itemToUpdate.getDescription());
        return this.itemRepository.save(dbItem);
    }

    @Transactional
    public void delete(Long id) {
        this.validateChangeableId(id, "deleted");
        Item dbItem = this.findById(id);
        this.itemRepository.delete(dbItem);
    }

    private void validateChangeableId(Long id, String operation) {
        if (UNCHANGEABLE_USER_ID.equals(id)) {
            throw new BusinessException("User with ID %d can not be %s.".formatted(UNCHANGEABLE_USER_ID, operation));
        }
    }
}
