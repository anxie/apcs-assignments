Branching & Merging Assignment
================

This is an assignment on branching and merging, based on your first Git assignment. 

Workflows
------------
In your first assignment, you learned one of many "workflows" you can use in Git. It went like this:

1. Make a change
2. Commit that change (on gh-pages branch)
3. Push the change to GitHub (to gh-pages branch)
4. Repeat.

Git is a very powerful tool that supports many different workflows. They all have different pros and cons and lots of different ones are used in industry. Today we're going to look at a workflow that integrates branching and merging.

What is Branching & Merging
----------------

A branch is like another "copy" of your repository (assignment) that you can make changes to. It's kinda like if you start working on "ProjectV1", then you copy it to "ProjectV2" to work on a big change (just in case it doesn't work and you want to go back). If it works out, you can copy the changes you made in ProjectV2 back into ProjectV1 ("merging", in Git). If it doesn't work, you can just delete ProjectV2 and try again.

A workflow like this is nice because you can easily undo if you realize the change you made isn't working. Git makes it super easy to go backwards and undo if you work on every new feature on its own branch and only merge when a feature is working (or "stable", as we call it in industry).

Part 1: Making a Change Using Branches
===================
In part 1 of this assignment, you're going to do exactly what you did in your first Git assignment, but using a branch.

In your first Git assignment, there was one branch: gh-pages. You made your change on that branch (in Sublime), committed (saved) to that branch (`git commit`), and pushed that branch to GitHub (`git push origin gh-pages`).

In this assignment, we're going to make a new branch called "add-my-name" and make our change to that copy. When we're done, we'll commit it (to "add-my-name") and then merge add-my-name back into gh-pages to send to GitHub.

1. Fork the repository at https://github.com/adamaflynn/MergingAssignment and clone your copy
2. See what branch we're on: `git branch` (the * beside gh-pages means we're on that branch)
3. Make a new branch: `git checkout -b add-my-name` (the `-b` means "make a new branch")
4. Now see what branch we're on: `git branch` (you'll see 2 branches, with the * beside add-my-name)
5. Open Sublime, change index.html to use your first name
6. Test your change. If this was a project, you'd run your work and keep making changes until it worked.
7. When everything works and you're ready to commit, go back to Git Bash
8. "Stage" your files for commit
9. Commit your change (to the add-my-name branch): `git commit -m "Added my first name to index.html"`
10. Switch back to gh-pages branch: `git checkout gh-pages` (note: no `-b`)
11. Open up index.html again. Notice that your name isn't in it (because that change is in add-my-name)
12. Merge add-my-name into gh-pages: `git merge add-my-name`
13. Open up index.html again. Now you should see your name.
14. Push your changes to GitHub: `git push origin gh-pages`
15. Go to github.io and see your changes
16. Keep your repository tidy! Delete add-my-name now that it's done: `git branch -d add-my-name`.

Part 2: Merge Conflicts 
===================

In part 1, we looked at an example where everything goes smoothly. But this isn't always the case. Imagine that there are 2 people working on this project (or you're working on 2 different branches at once). What would happen if both people tried to change the webpage to their own name and merge? If Mr. Simon and Adam were partners, Adam changed the title to "Adam's Sample Assignment", then Mr. Simon changed it to "Mr. Simon's Sample Assignment", Git wouldn't know what to do!

So what does Git do? Well, it asks for help. It tells you what files it's confused about and lets you decide what the right thing to do is.

This happens all the time in real software projects. If you have 20, 50, 100, or 1000 developers all working on the same repository all day, you're bound to accidentally touch the same things at the same time. I usually handle a couple merge conflicts a day.

To make things easy, I made a branch in this repository (add-adams-name) that has my name on it. After finishing part 1, if you try to merge add-adams-name into gh-pages, you'll have a merge conflict (since you already added your name). We'll look at how to fix that.

1. Add the add-adams-name branch from GitHub: `git branch add-adams-name origin/add-adams-name`
2. Make sure you're on the gh-pages branch (how do we do this, again?)
3. Try to merge add-adams-name: `git merge add-adams-name`
4. Git will say there's a conflict
5. Take a look at what files it's confused about: `git status`
6. You'll see index.html has a conflict, open it up in Sublime
7. Find lines like `<<<<<<<<<`, `===========`, and `>>>>>>>>>`. They show you the 2 versions Git has to choose from.
8. Decide how to fix the file. Maybe it's one or the other. Maybe it's a combination: if we were partners, you could change it to show both our names!
9. Test that change to make sure it works
10. "Stage" the file that you fixed
11. Type `git commit -m "Fixing merge conflict"`
12. Push the fixed gh-pages branch to GitHub
13. Check it out in github.io to make sure it works

Quick Reference
============

* See what branch you're on: `git branch`
* Make a new branch: `git checkout -b some-branch-name`
* Delete a branch: `git branch -d some-branch-name`
* Merge a branch onto the branch you're on: `git merge some-other-branch`
