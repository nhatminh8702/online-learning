import { Box, Button, Modal, TextField } from "@mui/material";
import { useEffect, useState } from "react";
import { ACCOUNT } from "../const";

const LessonModal = ({ open, onClose }) => {
  const [loginFormData, setLoginFormData] = useState({ user: "", pass: "" });
  const [modalError, setModalError] = useState(false);
  const [errorMessage, setErrorMessage] = useState("");

  function setCookie(name, value, days) {
    var expires = "";
    if (days) {
      var date = new Date();
      date.setTime(date.getTime() + days * 24 * 60 * 60 * 1000);
      expires = "; expires=" + date.toUTCString();
    }
    document.cookie = name + "=" + (value || "") + expires + "; path=/";
  }

  const handleClose = () => {
    onClose();
  };

  const login = () => {
    if (
      ACCOUNT.user === loginFormData.user &&
      ACCOUNT.pass === loginFormData.pass
    ) {
      setCookie("login", ACCOUNT.user, 7);
      onClose();
    } else {
      setModalError(true);
      setErrorMessage("User Name or Password is incorrect!");
    }
  };

  const handleChangeValue = (key, value) => {
    setModalError(false);
    setErrorMessage("");
    setLoginFormData((current) => ({ ...current, [key]: value }));
  };

  const style = {
    position: "absolute",
    top: "50%",
    left: "50%",
    transform: "translate(-50%, -50%)",
    width: 400,
    bgcolor: "background.paper",
    border: "2px solid #000",
    boxShadow: 24,
    p: 4,
    borderRadius: 4,
    display: "flex",
    flexDirection: "column",
    gap: 2,
  };

  return (
    <Box>
      <Modal
        open={open}
        onClose={handleClose}
        aria-labelledby="modal-modal-title"
        aria-describedby="modal-modal-description"
      >
        <Box className="quizForm" sx={style}>
          <Box>Login</Box>
          <TextField
            variant="standard"
            error={modalError}
            helperText={errorMessage}
            required
            id="outlined-required-small"
            label="User Name"
            value={loginFormData.user}
            onChange={(event) => handleChangeValue("user", event.target.value)}
          />
          <TextField
            variant="standard"
            required
            type="password"
            id="outlined-required-small"
            label="Password"
            value={loginFormData.pass}
            onChange={(event) => handleChangeValue("pass", event.target.value)}
          />
          <Box className="quizFormButton">
            <Button variant="contained" onClick={login}>
              Login
            </Button>
            <Button variant="contained" onClick={() => handleClose()}>
              Close
            </Button>
          </Box>
        </Box>
      </Modal>
    </Box>
  );
};
export default LessonModal;
