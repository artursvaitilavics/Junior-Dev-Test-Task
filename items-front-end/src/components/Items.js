import React, { useState, useEffect } from "react";
import Item from "./Item";
import AddItem from "./AddItem";
import DeleteItems from "./DeleteItems";

const Items = () => {
  const [items, setItems] = useState([]);
  const [itemsToDelete, setItemsToDelete] = useState([]);

  const urlAllItems = "http://localhost:8085/rest/api/BaseItem.svc/items";
  const postUrl = "http://localhost:8085/rest/api/BaseItem.svc/";

  useEffect(() => {
    console.log("items to delete: " + itemsToDelete);
    const getDataFromBackEnd = async () => {
      const data = await fetchData();
      setItems(data);
    };
    getDataFromBackEnd();
  }, []);

  const fetchData = async () => {
    const response = await fetch(urlAllItems);
    const data = await response.json();
    return data;
  };

  const addItem = async (item) => {
    const type = item.type;
    const requestUrl = postUrl + type;
    const response = await fetch(requestUrl, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(item),
    });
    const data = await response.json();

    setItems([...items, data]);
    // console.log(item);
  };

  // Remove from List if selected = false
  const selectItem = (item) => {
    console.log(item);
    // const selectedItems  =
    setItemsToDelete([...itemsToDelete, item]);

    // if (item.selected === true) {
    //   setItemsToDelete([...itemsToDelete, item]);
    // } else {
    //   const removeItem = itemsToDelete.filter(
    //     (item) => item.selected === true
    //   );
    //   setItemsToDelete(removeItem);
    // }
    // console.log(itemsToDelete);
  };

  const deleteItems = async () => {
    console.log(itemsToDelete);
    console.log(items);
    // const response = await fetch(urlAllItems, {
    //   method: "DELETE",
    //   headers: {
    //     "Content-Type": "application/json",
    //   },
    //   body: JSON.stringify(items),
    // });
  };

  return (
    <>
      <div>
        <AddItem onAddItem={addItem} />
      </div>
      <div>
        <DeleteItems onDelete={deleteItems} />
      </div>
      <div className="list-container">
        {items.map((item) => (
          <Item
            key={item.id}
            name={item.name}
            price={item.price}
            property={item.property}
            sku={item.sku}
            selector={selectItem}
          />
        ))}
      </div>
    </>
  );
};

export default Items;
