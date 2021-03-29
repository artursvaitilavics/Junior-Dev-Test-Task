import React from 'react'

const DeleteItems = ({onDelete}) => {
    return (
        <div>
            <input type="submit" value="Delete" className="delete-items" onClick={onDelete} />
        </div>
    )
}

export default DeleteItems
