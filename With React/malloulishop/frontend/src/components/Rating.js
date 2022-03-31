import React from 'react'
import ReactStars from "react-rating-stars-component";

function rating(props) {
    
    const {rating, numReviews} = props;

    const ratingStyle = {
      size: 25,
      value: rating,
      edit: false,
      isHalf: true
    };
    
  return (
    <div className="rating">
      <span><ReactStars {...ratingStyle} /></span>
      <span> {numReviews + ' Reviews'} </span>
    </div>
  )
}

export default rating