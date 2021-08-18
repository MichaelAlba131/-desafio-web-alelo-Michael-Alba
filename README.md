**Edit a file, create a new file, and clone from Bitbucket in under 2 minutes**

When you're done, you can delete the content in this README and update the file with details for others getting started with your repository.

*We recommend that you open this README in another tab as you perform the tasks below. You can [watch our video](https://youtu.be/0ocf7u76WSo) for a full demo of all the steps in this tutorial. Open the video in a new tab to avoid leaving Bitbucket.*

---

## Edit a file

You’ll start by editing this README file to learn how to edit a file in Bitbucket.

1. Click **Source** on the left side.
2. Click the README.md link from the list of files.
3. Click the **Edit** button.
4. Delete the following text: *Delete this line to make a change to the README from Bitbucket.*
5. After making your change, click **Commit** and then **Commit** again in the dialog. The commit page will open and you’ll see the change you just made.
6. Go back to the **Source** page.

---

## Create a file

Next, you’ll add a new file to this repository.

1. Click the **New file** button at the top of the **Source** page.
2. Give the file a filename of **contributors.txt**.
3. Enter your name in the empty file space.
4. Click **Commit** and then **Commit** again in the dialog.
5. Go back to the **Source** page.

Before you move on, go ahead and explore the repository. You've already seen the **Source** page, but check out the **Commits**, **Branches**, and **Settings** pages.

---

## Clone a repository

Use these steps to clone from SourceTree, our client for using the repository command-line free. Cloning allows you to work on your files locally. If you don't yet have SourceTree, [download and install first](https://www.sourcetreeapp.com/). If you prefer to clone from the command line, see [Clone a repository](https://confluence.atlassian.com/x/4whODQ).

1. You’ll see the clone button under the **Source** heading. Click that button.
2. Now click **Check out in SourceTree**. You may need to create a SourceTree account or log in.
3. When you see the **Clone New** dialog in SourceTree, update the destination path and name if you’d like to and then click **Clone**.
4. Open the directory you just created to see your repository’s files.

Now that you're more familiar with your Bitbucket repository, go ahead and add a new file locally. You can [push your change back to Bitbucket with SourceTree](https://confluence.atlassian.com/x/iqyBMg), or you can [add, commit,](https://confluence.atlassian.com/x/8QhODQ) and [push from the command line](https://confluence.atlassian.com/x/NQ0zDQ).

## Cenaries of Automation

API

1.      | cenary                                                                                                                                                            |
2.      | 001 - API - return notifications for the following countries: BR, AR                                                                                              |
3.      | 002 - API - perPage value should correspond to the number of notifications retrieved                                                                              |
4.      | 003 - API - content of notifications should be a xml encoded on Base64                                                                                            |
5.      | 004 - API - notificationId should be a valid GUID                                                                                                                 |
6.      | 005 - API - notificationId should correspond to ID inside content xml document                                                                                    |
7.      | 006 - API - 200 notifications should have Document Authorized on StatusReason and Document authorized successfully on Text fields inside content xml document     |
8.      | 007 - API - 400 notifications should have Document Rejected on StatusReason and Document was rejected by tax authority on Text fields inside content xml document |
9.      | 008 - API - Automation should display a warn in case of any rejected notification                                                                                 |


WEB

Testes 01 até o 06 necessitam de uma conta real na amazon, não realizei por causa de já possuir uma conta associada ao meu número de telefone.

1.      | cenary                                          | optionDropDownMenu | subOptionDropDownMenu | qtyProducts |
2.      | 001 - Validation of coupons and discounts       | Computers          | Monitors              | 2           |
3.      | 002 - Validation of address information         | Computers          | Monitors              | 1           |
4.      | 003 - Inventory data validation                 | Computers          | Monitors              | 1           |
5.      | 004 - Customer data validation                  | Computers          | Monitors              | 1           |
6.      | 005 - Payment flow validation                   | Computers          | Monitors              | 1           |
7.      | 006 - Freight calculation validation            | Computers          | Monitors              | 1           |
8.      | 007 - Validation of installment forms           | Computers          | Monitors              | 1           |
9.      | 008 - Order flow validation                     | Computers          | Monitors              | 1           |
10.     | 009 - Validation of the purchase process (cart) | Computers          | Monitors              | 2           |


Obs: Os relatórios de execução ficam em /src/test/java/Reports