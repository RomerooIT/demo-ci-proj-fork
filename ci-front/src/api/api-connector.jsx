import Axios from "axios";

const apiUrl = process.env.REACT_APP_API_URL;

export async function getPostData(){
    return await Axios.get("http://localhost:8081/api/v1/posts")
        .then(res => {
            console.log(res.data);
            return res.data
        })
        .catch(err => console.log(err));
}

export async function savePost(postData){
    return await Axios.post({apiUrl} + "create-post", postData)
        .then(res => res.data)
        .catch(err => console.log(err));
}