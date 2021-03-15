import React, { useState, useEffect } from "react";
import Item from "./Item";
import AddItem from "./AddItem";

const Items = () => {
  const [items, setItems] = useState([]);

  const urlAllItems = "http://localhost:8085/rest/api/BaseItem.svc/items";
  const urlAddDvd = "http://localhost:8085/rest/api/BaseItem.svc/dvd";

  useEffect(() => {
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
    const response = await fetch(urlAddDvd, {
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

  return (
    <>
      <div>
        <AddItem onAddItem={addItem} />
      </div>
      <div className="list-container">
        {items.map((item) => (
          <Item
            key={item.id}
            name={item.name}
            price={item.price}
            property={item.property}
            sku={item.sku}
          />
        ))}
      </div>
    </>
  );
};

export default Items;
