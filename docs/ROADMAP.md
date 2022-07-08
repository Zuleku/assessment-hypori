## Application Roadmap
This document provides a quick 

## Projects

#### Add Feature Sets
A simple project to distinguish and assign features to add to the API. The
added features should follow the same architecture & design patterns as
specified by the document and current implemented features.

#### Automate Data Ingestion
Since the data for each feature set is stored in a persistence layer we should
have a way to adjust and add to this set. This will increase usage of the API
as new data will consistently (how often is based on feature set) be added to
the API.

#### Refine & Design API
The initial design works and setups for immediate use of the API. To
effectively utilize the API and help make future changes adoption easier
there would need to be design considerations.

This project is applicable to converting and getting the API ready for public
use. This includes adding all necessary requirements to accommodate for
no-trust environment.

#### Solidify Storage Engines
An in-memory database works for some aspects but does not allow for great
persistence between redeploys. By changing out and solidifying a storage
persistence architecture to bind we can advance the usage possibilities of
the API.

## Timeline
Simple timeline based on a left-right viewing of what projects should be done
first and how to progress the app to accomplish the final goal. Most projects
will take roughly 1-2 months so each tab should reference about 2 months of
time. There can be multiple projects run at once to advance the API.

- Refine & Design API
  - Traceability
    - Security & API Keys
      - Subscription Service
- Solidify Storage Engines
  - Automate Data Ingestion
    - Add Feature Sets
