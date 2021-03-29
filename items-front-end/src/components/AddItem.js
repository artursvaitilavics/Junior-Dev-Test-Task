import React, { useState } from "react";

const AddItem = ({ onAddItem }) => {
  const [name, setName] = useState("");
  const [price, setPrice] = useState("");
  const [property, setProperty] = useState("");
  const [type, setType] = useState("");

  const addItem = (e) => {
    e.preventDefault();

    if (name == "" || price == "" || property == "") {
      alert("please check if is all the field are filled...");
      return;
    }

    onAddItem({type, name, price, property });

    setName("");
    setPrice("");
    setProperty("");
  };
  //   const [item, setItem] = useState();
  return (
    <div className="add-item-form">
      <form onSubmit={addItem}>
        
        <input
          type="text"
          placeholder="DVD"
          value={type}
          onChange={(e) => setType(e.target.value)}
        />
        <input
          type="text"
          placeholder="Name"
          value={name}
          onChange={(e) => setName(e.target.value)}
        />
        <input
          type="text"
          placeholder="Price"
          value={price}
          onChange={(e) => setPrice(e.target.value)}
        />
        <input
          type="text"
          placeholder="Property"
          value={property}
          onChange={(e) => setProperty(e.target.value)}
        />
        <input type="submit" name="SUBMIT" />
      </form>
    </div>
  );
};

export default AddItem;
