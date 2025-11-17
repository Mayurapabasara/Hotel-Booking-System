import axios from "axios"

export const api = axios.create({
    baseURL :"http://localhost:8080"
})

/*This functon ads a newroom to the databases */
export async function addRoom(photo, roomType, roomPrice){
    const fromData = new FormData()
    formData.append("photo", photo)
    formData.append("roomType", roomType)
    formData.append("roomPrice", roomPrice)
    
    const response = await api.post("/room/add/new-room", formData)
     if(response.status == 201){
        return true;
     }
     else{
        return false;
     }
}
    /* this fnction gets all room type from three database*/
 export async function getroomTypes() {
    try{
            const response = await api.get("/room/room-types")
            return response.data
    }
    catch(error){
            throw new Error("Error fetcing room types")
    }
 }
