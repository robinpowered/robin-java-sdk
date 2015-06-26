#!/bin/bash
#
# Deploy the javadoc website to the repository's gh-pages.
#
# Borrowed from http://benlimmer.com/2013/12/26/automatically-publish-javadoc-to-gh-pages-with-travis-ci/

SLUG="robinpowered/robin-java-sdk"
JDK="oraclejdk8"
BRANCH="master"

if [ "$TRAVIS_REPO_SLUG" == "$SLUG" ] && [ "$TRAVIS_JDK_VERSION" == "$JDK" ] && [ "$TRAVIS_PULL_REQUEST" == "false"] && [ "$TRAVIS_BRANCH" == "$BRANCH" ]; then

  echo -e "Publishing javadoc...\n"

  cp -R target/apidocs $HOME/javadoc-latest

  cd $HOME
  git config --global user.email "brian+mrhuboto@onemightyroar.com"
  git config --global user.name "mrhuboto"
  git clone --quiet --branch=gh-pages https://${CI_PUBLISH_APIDOC_KEY}@github.com/robinpowered/robin-java-sdk gh-pages > /dev/null

  cd gh-pages
  git rm -rf ./javadoc
  cp -Rf $HOME/javadoc-latest ./javadoc
  git add -f .
  git commit -m "Lastest javadoc on successful travis build $TRAVIS_BUILD_NUMBER auto-pushed to gh-pages"
  git push -fq origin gh-pages > /dev/null

  echo -e "Published Javadoc to gh-pages.\n"

fi
