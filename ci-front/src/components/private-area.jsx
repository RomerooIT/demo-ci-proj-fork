import {Button, Col, Container, Row} from "react-bootstrap";
import Post from "./post-item";
import {useEffect, useState} from "react";
import Axios from "axios";
import "./main.css"
import 'bootstrap/dist/css/bootstrap.min.css';
import {Link} from "react-router-dom";

const PrivateArea = () => {
    const [postData, setPostData] = useState([]);

    const splitArrayIntoGroups = (arr, groupSize) => {
        const result = [];
        for (let i = 0; i < arr.length; i += groupSize) {
            result.push(arr.slice(i, i + groupSize));
        }
        return result;
    }

    useEffect(() => {
        const fetchData = async () => {
            try {
                const response = await Axios.get("http://localhost:8081/api/v1/posts");
                setPostData(response.data);
            } catch (err) {
                console.error("Error fetching data:", err);
            }
        };

        fetchData();
    }, []);

    return (
        <>
            <Container>
                <Row style={{margin: '30px'}}>
                    <Col xs={10}>
                        {postData.length !== 0 ? (
                            splitArrayIntoGroups(postData, 3).map((batch) => (
                                <Row style={{margin: "20px"}}>
                                    {
                                        batch.map((post) => (
                                            <Col key={post.id}>
                                                <Post post={post}/>
                                            </Col>
                                            )
                                        )
                                    }

                                </Row>

                            ))
                        ) : (
                            <Col xs={12}>
                                <p className="text-center">Нет постов</p>
                            </Col>
                        )}
                    </Col>
                    <Col xs={2}>
                        <Link to="/create-post">
                            <Button variant="primary">
                                Добавить пост
                            </Button>
                        </Link>
                    </Col>
                </Row>
            </Container>
        </>
    );
};

export default PrivateArea;