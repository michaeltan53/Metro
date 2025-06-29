# New Code for Deliverable D2D

## < u6822656 > < Bowen Tan >

For Deliverable D2D, I contributed the following new statements of original code:

-
if (!Metro.isPlacementSequenceWellFormed(placement) || !Metro.isPlacementSequenceValid(placement) ) {
            Text t = new Text("Sorry, this placement is unacceptable!");
            t.setFill(Color.RED);
            t.setLayoutX(120);
            t.setLayoutY(680);
            this.placement.getChildren().add(t);
        } else {
            for (int i = 0; i <= placement.length() - 1; i += 6) {
                ImageView imageview = new ImageView();
                String tileType = String.valueOf(placement.charAt(i)) + placement.charAt(i + 1)
                        + placement.charAt(i + 2) + placement.charAt(i + 3);
                char rowNum = placement.charAt(i + 4);
                char colNum = placement.charAt(i + 5);
                ...
                this.placement.getChildren().add(imageview);
                            }
                        }
                    }
-

(List at least 10, and include line numbers.)
