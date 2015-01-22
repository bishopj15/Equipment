var gulp = require('gulp');
var concat = require('gulp-concat');
var jshint = require('gulp-jshint');
var sass = require('gulp-sass');
var beep = require('beepbeep');
var plumber = require('gulp-plumber');
var del = require('del');


var path = {
  rootViews: ['./assets/app/index.html', './assets/app/incompatible-browser.html'],
  views: ['./assets/app/**/*.html', '!./assets/app/index.html'],
  mainSass: ['./assets/app/main.scss'],
  scripts: ['./assets/app/**/*.js']
};

/**
 * Lints the javascript files using JSHint.
 * @return {[type]} [description]
 */
gulp.task('lint', function() {
  gulp.src(path.scripts)
    .pipe(jshint())
    // Maybe investigate good reports, or leave default.
    .pipe(jshint.reporter('default'));
});

/**
 * Beeps at user and logs the error to the console.
 */
var onError = function(err) {
  beep(2);
  console.log('GULP ERROR: ', err);
}

/**
 * Compiles main.scss into css, moves the compiled css into dist/css.
 * Uses gulp-plumber to send errors to onError.
 */
gulp.task('sass', function() {
  gulp.src(path.mainSass)
    .pipe(plumber({
      errorHandler: onError
    }))
    .pipe(sass())
    .pipe(gulp.dest('./WebContent/dist/app'));
});

/**
 * Copies index file into WebContent and the html partial views into dist/views.
 */
gulp.task('views', function() {
  // Get our index.html
  gulp.src(path.rootViews)
    .pipe(gulp.dest('./WebContent/'));

  // Get any other view files from assets/views
  gulp.src(path.views)
    .pipe(gulp.dest('./WebContent/dist/app'));
});


gulp.task('bundle', function() {
  gulp.src(path.scripts)
    // Bundle to a single file
    .pipe(concat('bundle.js'))
    // Output it to our dist folder
    .pipe(gulp.dest('./WebContent/dist/app'));
});

// Clean dist - deletes the dist folder.
gulp.task('clean', function() {
  console.log("gulp clean");
  del(['./WebContent/dist'], function(err) {
    if (err) {
      console.log("Error: ", err);
    }
  });

  del(['./WebContent/index.html', './WebContent/incompatible-browser.html'], function(err) {
    if (err) {
      console.log("Error: ", err);
    }
  })
});

gulp.task('resources', function() {
 gulp.src(['./assets/images/**/*.png'])
   .pipe(gulp.dest('./WebContent/dist/images'));
});

/* Should bundle needed components and deploy those instead of copying entire directory */
gulp.task('libs', function() {
  gulp.src('./assets/libs/**')
    .pipe(gulp.dest('./WebContent/dist/libs'));
});

// Rerun the task when a file changes
gulp.task('watch', ['lint'], function() {
  //Run lint and dist when any changes to app occur.
  gulp.watch(['./assets/app/**'], ['lint', 'dist']);

  // Watch for bower_components changes.
  gulp.watch(['./assets/libs/**'], [
    'libs'
  ]);
});

gulp.task('dist', function() {
  gulp.start('views', 'sass', 'bundle', 'libs', 'resources');
});

gulp.task('default', ['dist', 'lint']);
