package com.example.zoostoreproject.restExport;


import com.example.zoostoreproject.api.operations.item.addtag.AddTagToItemInput;
import com.example.zoostoreproject.api.operations.item.addtag.AddTagToItemOutput;
import com.example.zoostoreproject.api.operations.item.archive.ArchiveItemInput;
import com.example.zoostoreproject.api.operations.item.archive.ArchiveItemOutput;
import com.example.zoostoreproject.api.operations.item.create.CreateItemInput;
import com.example.zoostoreproject.api.operations.item.create.CreateItemOutput;
import com.example.zoostoreproject.api.operations.item.editproperties.EditItemPropertiesInput;
import com.example.zoostoreproject.api.operations.item.editproperties.EditItemPropertiesOutput;
import com.example.zoostoreproject.api.operations.item.get.allitems.GetAllItemsListInput;
import com.example.zoostoreproject.api.operations.item.get.allitems.GetAllItemsListOutput;
import com.example.zoostoreproject.api.operations.cartitem.getproperties.GetCartItemPropertiesInput;
import com.example.zoostoreproject.api.operations.cartitem.getproperties.GetCartItemPropertiesOutput;
import com.example.zoostoreproject.api.operations.item.get.bydescription.GetItemByDescriptionInput;
import com.example.zoostoreproject.api.operations.item.get.byid.GetItemByIdOutput;
import com.example.zoostoreproject.api.operations.item.get.bytagtitle.GetItemsIdByTagTitleInput;
import com.example.zoostoreproject.api.operations.item.get.bytagtitle.GetItemsIdByTagTitleOutput;
import com.example.zoostoreproject.api.operations.item.removetag.RemoveTagFromItemInput;
import com.example.zoostoreproject.api.operations.item.removetag.RemoveTagFromItemOutput;
import com.example.zoostoreproject.api.operations.item.get.bydescription.GetItemByDescriptionOutput;
import com.example.zoostoreproject.api.operations.item.warrantycardvalidation.WarrantyCardValidationInput;
import com.example.zoostoreproject.api.operations.item.warrantycardvalidation.WarrantyCardValidationOutput;
import com.example.zoostoreproject.api.operations.tags.get.bytitle.GetItemTagByTitleInput;
import com.example.zoostoreproject.api.operations.tags.get.bytitle.GetItemTagByTitleOutput;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

import java.util.Optional;


@Headers({"Content-Type: application/json"})
public interface ZooStoreRestClient {

   @RequestLine("GET /item/{id}")
   GetItemByIdOutput getItemById(@Param String id);

   @RequestLine("POST /item/description")
   GetItemByDescriptionOutput getItemByDescriptionRegex(GetItemByDescriptionInput input);
   //GET /item/tagTitle?title={title}&itemsPerPage={itemsPerPage}&currentPage={currentPage}"

   @RequestLine("POST /item/byTagTitle")
   GetItemsIdByTagTitleOutput getItemsByTagTitle(GetItemsIdByTagTitleInput input);

   @RequestLine("GET /tag/title/{title}")
   GetItemTagByTitleOutput getItemTagByTagTitle(@Param String title);

   @RequestLine("POST /item")
   CreateItemOutput createItem(CreateItemInput input);
   @RequestLine("POST /item/warrantyValidation")
   WarrantyCardValidationOutput warrantyValidation(WarrantyCardValidationInput input);

   @RequestLine("PATCH /item/archiveStatus")
   ArchiveItemOutput archiveItem(@Param ArchiveItemInput input);

   @RequestLine("PATCH /item/properties")
   EditItemPropertiesOutput editItemProperties(@Param EditItemPropertiesInput input);

   @RequestLine("PATCH /item/addTagToItem")
   AddTagToItemOutput addTagToItem(@Param AddTagToItemInput input);

   @RequestLine("PATCH /item/removeTagFromItem")
   RemoveTagFromItemOutput removeTagFromItem(@Param RemoveTagFromItemInput input);

   @RequestLine("POST /item/cartItemProperties")
   GetCartItemPropertiesOutput getCartItemProperties(GetCartItemPropertiesInput input);

   @RequestLine("GET /item/getAll")
   GetAllItemsListOutput getAllItems();


}
