import React from 'react';
import {BrowserRouter, Route, Routes } from 'react-router-dom';
import HomeScreen from './screens/HomeScreen';
import ProductScreen from './screens/ProductScreen';

function App() {
  return (
    <BrowserRouter>
    <div className="grid-container">
    <header className="row">
        <div>
            <a className="brand" href="/">Mallouli Shop</a>
        </div>
        <div>
            <a href="/cart">Cart </a>
            <a href="/singin">Sing In</a>
        </div>
    </header>
    <main>
    <Routes>
      <Route path='/product/:id' element={<ProductScreen />}></Route>
      <Route path="/" element={<HomeScreen />} exact />  
    </Routes>
    </main>
    <footer className="row center">
        All right reserved 2022
    </footer>
  </div>
</BrowserRouter>
  );
}

export default App;