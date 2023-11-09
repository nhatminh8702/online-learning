import { Box, Button, Collapse } from "@mui/material";
import { useState } from "react";
import ExpandLess from "@mui/icons-material/ExpandLess";
import ExpandMore from "@mui/icons-material/ExpandMore";

const LessonItem = ({ title, content, onDelete, onEdit }) => {
  const [collapse, setCollapse] = useState(false);
  const handleClick = () => {
    setCollapse(!collapse);
  };

  const handleDelete = () => {
    onDelete();
  };

  const handleEdit = () => {
    onEdit();
  };

  return (
    <Box className="itemContainer">
      <Box className="itemHeader">
        <Box className="itemTitle">{title}</Box>
        <Button variant="outlined" onClick={handleEdit}>
          Edit
        </Button>
        <Button variant="outlined" onClick={handleDelete}>
          Delete
        </Button>

        {collapse ? (
          <ExpandLess onClick={handleClick} />
        ) : (
          <ExpandMore onClick={handleClick} />
        )}
      </Box>
      <Collapse in={collapse} timeout="auto" unmountOnExit>
        <Box sx={{ textAlign: "start", padding: "0 0 0 8px" }}>{content}</Box>
      </Collapse>
    </Box>
  );
};
export default LessonItem;
