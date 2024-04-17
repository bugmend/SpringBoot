<template>
  <div id="app">
    <nav class="navbar navbar-expand navbar-light">
      <router-link to="/" class="navbar-brand">Penpulse</router-link>
      <div class="navbar-nav mr-auto">
        <li class="nav-item">
          <router-link to="/tutorials" class="nav-link" active-class="active"><i class="fa-regular fa-rectangle-list"></i> Tutorials</router-link>
        </li>
        <li class="nav-item">
          <router-link to="/add" class="nav-link" active-class="active">Add New Tutorial <i class="fa-regular fa-square-plus"></i></router-link>
        </li>

      </div>
    </nav>


    <div class="container mt-5 ">
      <router-view />
    </div>
  </div>
</template>

<script>
export default {
  name: "app"
};
</script>
