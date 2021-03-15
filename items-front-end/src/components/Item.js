import React from "react";

function Item({ id, name, price, property, sku }) {
  return (
    <div className="list-item" key={id} id={id}>
      <p>{name}</p>
      <div key={id} id={id} className="item-properties">
        <p>Price: {price}</p>
        <p>{property}</p>
        <p>Sku: {sku}</p>
      </div>
    </div>
  );
}

export default Item;
