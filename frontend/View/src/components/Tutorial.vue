<template>
  <div v-if="currentTutorial" class="edit-form">
    <h4>Tutorial</h4>
    <form>
      <div class="form-group">
        <label for="title">Title</label>
        <input type="text" class="form-control" id="title"
          v-model="currentTutorial.title"
        />
      </div>
      <div class="form-group">
        <label for="description">Description</label>
        <input type="text" class="form-control" id="description"
          v-model="currentTutorial.description"
        />
      </div>

      <div class="form-group">
        <label><strong>Status:</strong></label>
        <span :class="{'text-success': currentTutorial.published, 'text-warning': !currentTutorial.published}">
          {{ currentTutorial.published ? ' Published' : ' Pending' }}
          <i :class="currentTutorial.published ? 'fa-solid fa-check' : 'fa-regular fa-clock'"></i>
        </span>
      </div>


    </form>

    <button class="btn btn-primary btn-sm"
      v-if="currentTutorial.published"
      @click="updatePublished(false)"
    >
      <i class="fa-regular fa-eye-slash"></i> UnPublish
    </button>
    <button v-else class="btn btn-primary btn-sm"
      @click="updatePublished(true)"
    >
      <i class="fa-regular fa-eye"></i> Publish
    </button>

    <button class="btn btn-danger btn-sm ml-2"
      @click="deleteTutorial"
    >
      <i class="fa-solid fa-trash-can"></i> Delete
    </button>

    <button type="submit" class="btn btn-warning  btn-sm ml-2"
      @click="updateTutorial"
    >
      <i class="fa-solid fa-pen"></i> Update
    </button>
    <p class="alert alert-info mt-2">{{ message }}</p>
  </div>

  <div v-else class="alert alert-info">
    <br />
    <p>Please click on a Tutorial...</p>
  </div>
</template>

<script>
import TutorialDataService from "../services/TutorialDataService";

export default {
  name: "tutorial",
  data() {
    return {
      currentTutorial: null,
      message: ''
    };
  },
  methods: {
    getTutorial(id) {
      TutorialDataService.get(id)
        .then(response => {
          this.currentTutorial = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },

    updatePublished(status) {
      var data = {
        id: this.currentTutorial.id,
        title: this.currentTutorial.title,
        description: this.currentTutorial.description,
        published: status
      };

      TutorialDataService.update(this.currentTutorial.id, data)
        .then(response => {
          console.log(response.data);
          this.currentTutorial.published = status;
          this.message = 'The status was updated successfully!';
        })
        .catch(e => {
          console.log(e);
        });
    },

    updateTutorial() {
      TutorialDataService.update(this.currentTutorial.id, this.currentTutorial)
        .then(response => {
          console.log(response.data);
          this.message = 'The tutorial was updated successfully!';
        })
        .catch(e => {
          console.log(e);
        });
    },

    deleteTutorial() {
      TutorialDataService.delete(this.currentTutorial.id)
        .then(response => {
          console.log(response.data);
          this.$router.push({ name: "tutorials" });
        })
        .catch(e => {
          console.log(e);
        });
    }
  },
  mounted() {
    this.message = '';
    this.getTutorial(this.$route.params.id);
  }
};
</script>

<style>
.edit-form {
  max-width: 300px;
  margin: auto;
}
</style>
