import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import picService from "../services/picService";

function Home() {
  const [pics, setPics] = useState([]);

  useEffect(() => {
    picService.getAll().then(setPics);
  }, []);

  return (
    <div>
      <h1>Tous les souvenirs</h1>

      {pics.map(pic => (
        <div key={pic.id}>
          <Link to={`/pics/${pic.id}`}>
            <img src={pic.url} width="200" />
          </Link>
          <p>{pic.title}</p>
        </div>
      ))}
    </div>
  );
}

export default Home;
