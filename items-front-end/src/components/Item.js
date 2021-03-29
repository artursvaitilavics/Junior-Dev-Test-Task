import React, { useState } from "react";
import PropTypes from "prop-types";

function Item({ selector, id, name, price, property, sku }) {
  const [selected, setSelected] = useState(false);
  const [selectedId, setSelectedId] = useState(id);
  const [selectedName, setSelectedName] = useState(name);
  const [selectedPrice, setSelectedPrice] = useState(price);
  const [selectedProperty, setSelectedProperty] = useState(property);
  const [selectedSku, setSelectedSku] = useState(sku);

  const onSelect = (e) => {
    setSelected(e.target.checked);

    selector({
      selected,
      selectedId,
      selectedName,
      selectedPrice,
      selectedProperty,
      selectedSku,
    });
  };

  const color = "#00ff00";

  return (
    <div
      className="list-item"
      key={id}
      id={id}
      style={{ backgroundColor: selected ? "#ff0000" : "#00ff00" }}
    >
      <p>{name}</p>

      <div key={id} id={id} className="item-properties">
        <p>Price: {price}</p>
        <p>{property}</p>
        <p>Sku: {sku}</p>
      </div>
      <input type="checkbox" onChange={(e) => onSelect(e)} />
    </div>
  );
}

export default Item;

Item.propTypes = {
  select: PropTypes.bool,
};
