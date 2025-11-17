import React, { useState, useEffect } from 'react'
import { getroomTypes } from '../utils/ApiFunctions'

const RoomTypeSelector = ({}) => {

    const [roomTypes, setRoomTypes] = useState([""]);
    const [showNewRoomTypeInput, setShowRoomTypesInput] = useState(false);
    const [newRoomType, setNewRoomType] = useState("");

    useEffect(() => {
        async function fetchRoomTypes() {
            try {
                const data = await getroomTypes();
                setRoomTypes(data);
            } catch (error) {
                console.error("Failed to load room types:", error);
            }
        }

        fetchRoomTypes();
    }, []);



    const handleNewRoomInputChange = (e: { target: { value: React.SetStateAction<string>; }; }) => {
        setNewRoomType(e.target.value);
    }

    const handleAddNewRoomType = () =>{
        if(newRoomType !== ""){
            setRoomTypes([...roomTypes, newRoomType])
            setNewRoomType("")
            setShowRoomTypesInput(false)
        }
    }







    return (
        <>
            {roomTypes.length > 0 && (
                <div>
                    <select
                        id="roomType"
                        name="roomType"
                        className='form-select'
                        value={newRoom.roomType}
                        onChange={(e) => {
                            if(e.target.value === "Add New"){
                                setShowRoomTypesInput(true)
                            }
                            else{
                                handleNewRoomInputChange(e)
                            }
                        }}
                    />
                </div>
            )}
        
        </>
    )
}

export default RoomTypeSelector;
