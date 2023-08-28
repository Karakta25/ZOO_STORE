package com.example.zoostoreproject.core.item.get.bytagtitle;

import com.example.zoostoreproject.api.operations.item.get.bytagtitle.GetItemsIdByTagTitleInput;
import com.example.zoostoreproject.api.operations.item.get.bytagtitle.GetItemsIdByTagTitleOperation;
import com.example.zoostoreproject.api.operations.item.get.bytagtitle.GetItemsIdByTagTitleOutput;
import com.example.zoostoreproject.core.exception.item.NoSuchItemException;
import com.example.zoostoreproject.persistence.entities.Item;
import com.example.zoostoreproject.persistence.repositories.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GetItemsIdByTagTitleOperationProcessor implements GetItemsIdByTagTitleOperation {

    private final ItemRepository itemRepository;
    @Override
    public GetItemsIdByTagTitleOutput process(GetItemsIdByTagTitleInput input) {

        List<UUID> itemsId = input.getCartItemsId().stream()
                .map(id -> itemRepository.findById(id)
                        .orElseThrow(NoSuchItemException::new))
                .filter(item -> item.getTags().stream()
                        .anyMatch(tag -> tag.getTitle().equals(input.getTagTitle())))
                .map(Item::getId)
                .collect(Collectors.toList());

        return GetItemsIdByTagTitleOutput.builder()
                .itemsId(itemsId)
                .build();
    }

}
