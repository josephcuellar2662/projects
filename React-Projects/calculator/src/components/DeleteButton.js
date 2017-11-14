import React from 'react';
import PropTypes from "prop-types";

const DeleteBtn = props =>
  <button
    className="deleteBtn"
    onClick={() => props.handleDelete()}>{props.value}</button>;

DeleteBtn.propTypes = {
  value: PropTypes.string.isRequired,
  handleDelete: PropTypes.func.isRequired
};

export default DeleteBtn;
