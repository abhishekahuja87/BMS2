Basic Commands
-------------
"npm start" - Used only for development, this starts a server at port 3000 and renders the report UI using a report json already 
    present(without making the REST call)
"npm run build"- Used to make a production build(same is also done as part of build script) and put in right place in the product. 
    New chnages done in 10.1.1 for the export option, this command noe does more work. Like seen in the "scripts" in package.json, 
    this command now build a zip and puts it in the same build directory long with other files. This new zip called 
    "export-ui-build.zip" is used for export to html option. If you are not interested in the export zip, you can run 
    "npm run build-default", which will only build the UI build excluding the zip file to save some time. To achieve the making
    of zip file we use a number of dev dependencies to help us as seen in the "build" command in "scrips" in package.json
We also check for "production/developement" build to render some contents which are default react supported environment variables. 
    All the development code in removed in production build

Details about the flow/code etc
-------------------------------
"App.js"- The actual start of the code, where we just render our main component "MainPage.jsx"
"MainPage.jsx"- This is actual start point for a developer to start putting the code or understand the flow. Here we make REST call 
    to get the unified report json and then render components like Navbar, TopStatusFragment, SummarySection, TestDetailsSection. 
    This also means that, the report has mainly 4 components that are rendered
"Navbar.jsx"- this has all the navbar items rendered
"TopStatusFragment.jsx"- This is the section below the navbar where we render name of test, location, date, time etc
"SummarySection.jsx"- This renders the doughnut section and Summary & Resources table
"TestDetailsSection.jsx"- This renders all the Test Tabs/Collapse panels, renders the icons on the panels. Also renders another 
    component inside the panel called "TestTabContents.jsx" which renders all test steps and its details
"TestTabContents.jsx"- This is not rendered direcly as a component in MainPage.jsx but rendered from with "TestDetailsSection.jsx" 
    and does a lot of job. It renders different components like Steps Tree component, the step details Table component and 
    Screensshots. It also manages the all the VPs depending on conditions which are separate components like: TextVp.jsx, ImageVp.jsx, 
    Property.jsx, ListVp.jsx, TableVp.jsx, StateVp.jsx, GenericVpWithTreeNodeAndProperties.jsx

Debug
-----
TestTabContents.jsx- This has some special condition to directly put the VPs json and the type of vp. So that while dev we can avoid 
    REST call to get VP json and debug/develop VPs easily. All this code is only applicable in development and removed in production.
We also have some hardcoded commented links to images for ImageVP and Steps screenshots to develop/debug screenshots/imagevp easily

How Export Report works
-----------------------
- In MainPage.jsx, we have a condition to not make a REST call if its a production build and server is not available, then use a 
    dummy JSON(empty.json) which will render a blank loading page. We also have a production build stored in our backend code with 
    changes to package.json's homepage property. The homeage should be set to a DOT (.). With these changes we make a production build 
    using "npm run build" and store it at our backend code. On click of the Export button in UI, the java backend code unzips the 
    special UI build (used only for Export) stored in backend war file and edits the JS file to put the proper json contents in the 
    right place, so we don't have to make REST call to get data.
- We also have conditions in different places whereever we make REST calls to get json data or images, to not make those REST calls 
    and ensure that the JS code looks for the contens in current directory. The backend code on click of "Export" button ensures all 
    the data/images the ths JS code looks for in current directory is available in the place its looking for example: the backend code 
    makes the images available in right place. It also make the RFT's VPs json data available inline in the unified json. Since we 
    can't make REST calls so backend data makes all the REsources available to JS code.

