import logo from "./logo.svg";
import "./App.css";
import { useEffect, useState } from "react";

function App() {
  const [data, setData] = useState();
  const getApi = async () => {
    const res = await fetch("http://10.33.32.150:8080/api/dummy");
    res.json().then((data) => {
      setData(data);
    });
  };

  useEffect(() => {
    getApi();
  }, []);

  console.log(data);

  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
      </header>
    </div>
  );
}

export default App;
