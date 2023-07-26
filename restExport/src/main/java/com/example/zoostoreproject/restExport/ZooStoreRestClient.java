package com.example.zoostoreproject.restExport;


import com.example.zoostoreproject.api.operations.item.addTagToItem.AddTagToItemInput;
import com.example.zoostoreproject.api.operations.item.addTagToItem.AddTagToItemOutput;
import com.example.zoostoreproject.api.operations.item.archiveItem.ArchiveItemInput;
import com.example.zoostoreproject.api.operations.item.archiveItem.ArchiveItemOutput;
import com.example.zoostoreproject.api.operations.item.createItem.CreateItemInput;
import com.example.zoostoreproject.api.operations.item.createItem.CreateItemOutput;
import com.example.zoostoreproject.api.operations.item.editItemProperties.EditItemPropertiesInput;
import com.example.zoostoreproject.api.operations.item.editItemProperties.EditItemPropertiesOutput;
import com.example.zoostoreproject.api.operations.item.getAllItems.GetAllItemsListInput;
import com.example.zoostoreproject.api.operations.item.getAllItems.GetAllItemsListOutput;
import com.example.zoostoreproject.api.operations.item.getItemById.GetItemByIdOutput;
import com.example.zoostoreproject.api.operations.item.removeTagFromItem.RemoveTagFromItemInput;
import com.example.zoostoreproject.api.operations.item.removeTagFromItem.RemoveTagFromItemOutput;
import feign.Headers;
import feign.Param;
import feign.RequestLine;



@Headers({"Content-Type: application/json"})
public interface ZooStoreRestClient {


   @RequestLine("GET /item/{id}")
   GetItemByIdOutput getItemById(@Param String id);

   @RequestLine("POST /item")
   CreateItemOutput createItem(@Param CreateItemInput input);

   @RequestLine("PATCH /item/archiveStatus")
   ArchiveItemOutput archiveItem(@Param ArchiveItemInput input);

   @RequestLine("PATCH /item/properties")
   EditItemPropertiesOutput editItemProperties(@Param EditItemPropertiesInput input);

   @RequestLine("PATCH /item/addTagToItem")
   AddTagToItemOutput addTagToItem(@Param AddTagToItemInput input);

   @RequestLine("PATCH /item/removeTagFromItem")
   RemoveTagFromItemOutput removeTagFromItem(@Param RemoveTagFromItemInput input);

   @RequestLine("GET /item/getAll")
   GetAllItemsListOutput getAllItems(@Param GetAllItemsListInput input);


}
