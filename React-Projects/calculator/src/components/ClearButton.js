import React from 'react';
import PropTypes from "prop-types";

const ClearBtn = props =>
  <button
    className="clearBtn"
    onClick={() => props.clear()}>{props.value}</button>;

ClearBtn.propTypes = {
  value: PropTypes.string.isRequired,
  clear: PropTypes.func.isRequired
};

export default ClearBtn;
