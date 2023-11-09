import { useState } from "react";

import QuizItem from "./QuizItem";
import { Box, Button } from "@mui/material";
import QuizModal from "./QuizModal";
import { QUIZ_LIST } from "../const";

const QuizTab = () => {
  const [quizList, setQuizList] = useState(QUIZ_LIST);
  const [editModel, setEditModel] = useState(false);
  const [quiz, setQuiz] = useState({
    id: 0,
    courseId: 1,
    title: "",
    description: "",
    passingScore: 0,
  });
  const [openModal, setOpenModal] = useState(false);

  const handleClickDelete = (id) => {
    setQuizList((current) => current.filter((item) => item.id != id));
  };

  const handleClickEdit = (id) => {
    setQuiz(quizList.find((item) => item.id === id));
    setEditModel(true);
    setOpenModal(true);
  };

  const maxId = () => {
    var id = 0;
    for (let i = 0; i < quizList.length; i++) {
      if (quizList[i].id > id) {
        id = quizList[i].id;
      }
    }
    return id;
  };

  const handleAddQuiz = (value) => {
    if (editModel) {
      var _quiz = JSON.parse(JSON.stringify(quizList));
      for (let i = 0; i < _quiz.length; i++) {
        if (_quiz[i].id === value.id) _quiz[i] = value;
      }
      setQuizList(_quiz);
      setEditModel(false);
    } else {
      setQuizList((current) => [...current, { id: maxId, ...value }]);
    }
    setQuiz({
      id: 0,
      courseId: 1,
      title: "",
      description: "",
      passingScore: 0,
    });
    setOpenModal(false);
  };

  return (
    <div className="container">
      {quizList.map((item) => (
        <QuizItem
          key={item.id}
          title={item.title}
          passingScore={item.passingScore}
          description={item.description}
          onDelete={() => {
            handleClickDelete(item.id);
          }}
          onEdit={() => {
            handleClickEdit(item.id);
          }}
        />
      ))}
      <Box className="containerFooter">
        <Button variant="contained" onClick={() => setOpenModal(true)}>
          Add Quiz
        </Button>
      </Box>
      <QuizModal
        editModel={editModel}
        open={openModal}
        quiz={quiz}
        onAdd={handleAddQuiz}
        onClose={() => setOpenModal(false)}
      />
    </div>
  );
};
export default QuizTab;
