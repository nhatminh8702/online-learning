import { Box, Button, Modal, TextField } from "@mui/material";
import { useEffect, useState } from "react";

const LessonModal = ({ open, lesson, onClose, onAdd }) => {
  const [lessonFormData, setLessonFormData] = useState(lesson);
  const handleClose = () => {
    onClose();
  };

  useEffect(() => {
    setLessonFormData(lesson);
  }, [lesson]);

  console.log(lessonFormData);
  const handleClickAdd = () => {
    onAdd(lessonFormData);
  };

  const handleChangeValue = (key, value) => {
    setLessonFormData((current) => ({ ...current, [key]: value }));
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
          <Box>Quiz</Box>
          <TextField
            variant="standard"
            required
            id="outlined-required-small"
            label="Title"
            value={lessonFormData.title}
            onChange={(event) => handleChangeValue("title", event.target.value)}
          />
          <TextField
            id="filled-multiline-static-small"
            label="Content"
            multiline
            rows={4}
            variant="filled"
            value={lessonFormData.content}
            onChange={(event) =>
              handleChangeValue("content", event.target.value)
            }
          />
          <Box className="quizFormButton">
            <Button variant="contained" onClick={() => handleClickAdd()}>
              submit
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
