import { Box, Button, Tab, Tabs } from "@mui/material";
import "./App.css";
import { useEffect, useState } from "react";
import { useCallback } from "react";
import LessonTab from "./components/LessonTab";
import QuizTab from "./components/QuizTab";
import LoginModel from "./components/LoginModel";

function App() {
  const [tab, setTab] = useState(0);
  const [toggleLogin, setToggleLogin] = useState(false);
  const [userName, setUserName] = useState("");

  function getCookie(name) {
    var nameEQ = name + "=";
    var ca = document.cookie.split(";");
    for (var i = 0; i < ca.length; i++) {
      var c = ca[i];
      while (c.charAt(0) == " ") c = c.substring(1, c.length);
      if (c.indexOf(nameEQ) == 0) return c.substring(nameEQ.length, c.length);
    }
    return null;
  }

  function eraseCookie(name) {
    document.cookie =
      name + "=; Path=/; Expires=Thu, 01 Jan 1970 00:00:01 GMT;";
  }

  const handleLogout = () => {
    setUserName(null);
    eraseCookie("login");
  };

  const a11yProps = useCallback(() => {
    return {
      id: `simple-tab-${tab}`,
      "aria-controls": `simple-tabpanel-${tab}`,
    };
  }, [tab]);

  const handleChange = (event, newValue) => {
    setTab(newValue);
  };

  useEffect(() => {
    setUserName(getCookie("login"));
  }, [toggleLogin]);

  return (
    <div className="App">
      <div className="App-header">
        <div className="header">
          <img className="icon" src="logo192.png" alt="..." />
          <Box sx={{ flex: 1, textAlign: "start" }} className="Title">
            <p className="subTitle">SWD392</p>
            <p className="mainTitle">Online Learning</p>
          </Box>
          <Box sx={{ margin: " 0 16px 0 0" }} className="login">
            {userName === null && (
              <Button variant="outlined" onClick={() => setToggleLogin(true)}>
                Login
              </Button>
            )}

            {userName != null && (
              <Box sx={{ display: "flex", gap: 2 }}>
                <Box>Hi, {userName}</Box>
                <Button variant="outlined" onClick={() => handleLogout()}>
                  log out
                </Button>
              </Box>
            )}
          </Box>
        </div>
        <div className="body">
          <Box sx={{ width: "100%" }}>
            <Box
              sx={{ borderBottom: 1, borderColor: "rgba(194, 224, 255, 0.08)" }}
            >
              <Tabs textColor="inherit" value={tab} onChange={handleChange}>
                <Tab label="Quiz" {...a11yProps(0)} />
                <Tab label="Lesson" {...a11yProps(1)} />
              </Tabs>
            </Box>
            {tab === 0 && <QuizTab />}
            {tab === 1 && <LessonTab />}
          </Box>
        </div>

        <LoginModel open={toggleLogin} onClose={() => setToggleLogin(false)} />
      </div>
    </div>
  );
}

export default App;
